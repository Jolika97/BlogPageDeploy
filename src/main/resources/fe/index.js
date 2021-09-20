var navArray = ["Travel updates", "Reviews", "About", "Contact"];

var articleArrayFromServer = [];

var startingIndex = 0;

var id = 0;

function getArticles() {
  fetch("https://blogpagedeploy.herokuapp.com/articles", { method: "GET" })
    .then(function (response) {
      if (response.status !== 200) {
        console.log(
          "Looks like there was a problem. Status Code: " + response.status
        );
        return;
      }

      response.json().then(function (data) {
        renderArticles(data);
        console.log(data);
        articleArrayFromServer = data;
        console.log(articleArrayFromServer);
      });
    })

    .catch(function (err) {
      console.log("Fetch Error :-S", err);
    });
}

function renderArticles(articleArray) {
  console.log("Render method is called!");
  //Starting to create the page
  let container = document.getElementById("root");

  //Header
  function createHeader() {
    let nav = document.createElement("nav");
    nav.setAttribute("class", "nav");

    let ul = document.createElement("ul");
    ul.setAttribute("class", "nav__container");

    navArray.forEach((element) => {
      let li = document.createElement("li");
      li.setAttribute("class", "nav__item");
      li.textContent = element;
      ul.appendChild(li);

      let a = document.createElement("a");
      a.setAttribute("class", "nav__link");
      a.href = "#";

      li.appendChild(a);

      ul.appendChild(li);
    });

    nav.appendChild(ul);
    container.appendChild(nav);
  }

  //Button
  function createAddArticleButton() {
    let buttonDiv = document.createElement("div");
    buttonDiv.setAttribute("class", "add__container");

    let button = document.createElement("button");

    button.setAttribute("class", "button");
    button.setAttribute("type", "button");
    button.setAttribute("id", "add-article-button");
    button.textContent = "+Add article";

    button.addEventListener("click", function () {
      id = 0;
    });

    buttonDiv.appendChild(button);
    container.appendChild(buttonDiv);
  }

  let main = document.createElement("main");

  //Main with articles
  function createArticle(articleArray) {
    articleArray.map((element) => {
      let article = document.createElement("article");

      let title = document.createElement("h2");
      title.setAttribute("class", "title");
      title.textContent = element.title;

      article.appendChild(title);

      let insideArticleUl = document.createElement("ul");
      insideArticleUl.setAttribute("class", "info__container");

      //Article ul
      let insideArticleLi1 = document.createElement("li");
      insideArticleLi1.setAttribute("class", "info__item");
      insideArticleLi1.textContent = element.tag;
      insideArticleLi1.textContent = "Added by ";

      let span = document.createElement("span");
      span.setAttribute("class", "info__mark");
      span.textContent = element.author;
      insideArticleLi1.appendChild(span);

      //Article ul
      let insideArticleLi2 = document.createElement("li");
      insideArticleLi2.setAttribute("class", "info__item");
      insideArticleLi2.textContent = element.date;

      insideArticleUl.appendChild(insideArticleLi1);
      insideArticleUl.appendChild(insideArticleLi2);

      article.appendChild(insideArticleUl);

      //Article buttons
      let articleButtonDiv = document.createElement("div");
      articleButtonDiv.setAttribute("class", "actions__container");

      let articleButton1 = document.createElement("button");
      articleButton1.setAttribute("class", "actions__btn");
      articleButton1.setAttribute("type", "button");
      articleButton1.textContent = "Edit";

      articleButton1.addEventListener("click", function () {
        id = element.id;
        fillModal(element);
      });

      articleButtonDiv.appendChild(articleButton1);

      let articleButton2 = document.createElement("button");
      articleButton2.setAttribute("class", "actions__btn");
      articleButton2.setAttribute("type", "button");
      articleButton2.textContent = "Delete";

      articleButton2.addEventListener("click", function () {
        deleteArticle(element.id);
      });

      articleButtonDiv.appendChild(articleButton2);

      article.appendChild(articleButtonDiv);

      //Article image
      let image = document.createElement("img");
      image.setAttribute(
        "src",
        `https://blogpagedeploy.herokuapp.com/${element.imageURL}`
      );

      article.appendChild(image);

      //Article text

      let articleTextDiv = document.createElement("div");
      articleTextDiv.setAttribute("class", "content__container");

      let paragraph = document.createElement("p");
      paragraph.textContent = element.content;
      articleTextDiv.appendChild(paragraph);

      let articleReadMore = document.createElement("div");
      articleReadMore.setAttribute("class", "readmore__container");

      let buttonReadMore = document.createElement("button");
      buttonReadMore.setAttribute("class", "button");
      buttonReadMore.setAttribute("type", "button");
      buttonReadMore.textContent = "Read More";

      buttonReadMore.addEventListener("click", function () {
        id = element.id;
        getOneArticle(element.id);
      });

      articleReadMore.appendChild(buttonReadMore);
      article.appendChild(articleReadMore);

      article.appendChild(articleTextDiv);

      main.appendChild(article);
    });
  }

  function createFooter() {
    let footer = document.createElement("footer");
    footer.setAttribute("class", "footer");

    let footerButtonPrevious = document.createElement("button");
    footerButtonPrevious.setAttribute("class", "footer__link");
    footerButtonPrevious.textContent = "previous";

    if (startingIndex <= 3) {
      footerButtonPrevious.disabled = true;
      footerButtonPrevious.style.color = "gray";
    }

    footerButtonPrevious.addEventListener("click", function () {
      goToPreviousPage(container, footerButtonNext);
    });

    let footerButtonNext = document.createElement("button");
    footerButtonNext.setAttribute("class", "footer__link footer__link--next");
    footerButtonNext.textContent = "next";

    if (startingIndex > articleArray.length - 3) {
      footerButtonNext.disabled = true;
      footerButtonNext.style.color = "gray";
    }

    footerButtonNext.addEventListener("click", function () {
      goToNextPage(container);
    });

    footer.appendChild(footerButtonPrevious);
    footer.appendChild(footerButtonNext);

    main.appendChild(footer);
  }

  function createInput(content) {
    let input = document.createElement("input");
    input.setAttribute("type", "text");
    input.setAttribute("class", "input");
    input.placeholder = "Please enter " + content;
    return input;
  }

  function setMultipleAttributes(node, attr) {
    for (let i in attr) {
      node.setAttribute(i, attr[i]);
    }
  }

  function createModal() {
    let modal_overlay = document.createElement("div");
    modal_overlay.setAttribute("class", "modal__overlay");
    modal_overlay.setAttribute("id", "modal_overlay");
    modal_overlay.style.setProperty("display", "none");

    let modal = document.createElement("div");
    modal.setAttribute("class", "modal");

    let modal_content = document.createElement("div");
    modal_content.setAttribute("class", "modal__content");

    let h2 = document.createElement("h2");
    h2.setAttribute("class", "title");
    h2.textContent = "Add/Edit article";

    let input_container = document.createElement("div");
    input_container.setAttribute("class", "inputs__container");

    input_container.append(
      createInput("title"),
      createInput("tag"),
      createInput("author"),
      createInput("date"),
      createInput("image url"),
      createInput("saying")
    );

    let textarea = document.createElement("textarea");
    setMultipleAttributes(textarea, {
      class: "textarea",
      name: "content",
      cols: "28",
      rows: "7",
    });

    let modal_button = document.createElement("div");
    modal_button.setAttribute("class", "modal__buttons");

    let modalCancelButton = document.createElement("button");
    setMultipleAttributes(modalCancelButton, {
      type: "button",
      class: "button",
      id: "close-modal-button",
    });
    modalCancelButton.textContent = "Cancel";

    modalCancelButton.addEventListener("click", function () {
      clearInputs();
    });

    let modalSaveButton = document.createElement("button");
    setMultipleAttributes(modalSaveButton, {
      type: "button",
      class: "button button--pink",
    });
    modalSaveButton.textContent = "Save";

    modalSaveButton.addEventListener("click", function () {
      saveArticle(id);
    });

    modal_button.append(modalSaveButton, modalCancelButton);

    modal_content.append(h2, input_container, textarea, modal_button);
    modal.appendChild(modal_content);
    modal_overlay.appendChild(modal);

    container.appendChild(modal_overlay);
  }

  function getOneArticle(id) {
    fetch(`https://blogpagedeploy.herokuapp.com/article/${id}`)
      .then(function (response) {
        if (response.status !== 200) {
          console.log(
            "Looks like there was a problem. Status Code: " + response.status
          );
          return;
        }

        response.json().then(function (data) {
          console.log(data);
        });
      })

      .catch(function (err) {
        console.log("Fetch Error :-S", err);
      });
  }

  function fillModal(data) {
    document.getElementById("modal_overlay").style.display = "block";
    let inputs = document.getElementsByClassName("input");
    console.log(inputs);
    inputs.item(0).value = data.title;
    inputs.item(1).value = data.tag;
    inputs.item(2).value = data.author;
    inputs.item(3).value = data.date;
    inputs.item(4).value = data.imageURL;
    inputs.item(5).value = data.saying;

    document.getElementsByClassName("textarea").item(0).value = data.content;
  }

  function saveArticle(id) {
    let inputs = document.getElementsByClassName("input");
    const putObject = {
      title: inputs.item(0).value,
      tag: inputs.item(1).value,
      author: inputs.item(2).value,
      date: inputs.item(3).value,
      imageURL: inputs.item(4).value,
      saying: inputs.item(5).value,
      content: document.getElementsByClassName("textarea").item(0).value,
    };

    if (id == 0) {
      fetch(`https://blogpagedeploy.herokuapp.com/article`, {
        method: "POST",
        headers: {
          "Content-type": "application/json",
        },
        body: JSON.stringify(putObject),
      }).then(function () {
        alert("Added successfully!");
        document.body.innerHTML = "";
        getArticles();
      });
    } else {
      fetch(`https://blogpagedeploy.herokuapp.com/article/${id}`, {
        method: "PUT",
        headers: {
          "Content-type": "application/json",
        },
        body: JSON.stringify(putObject),
      }).then(function () {
        alert("Edited successfully!");
        document.body.innerHTML = "";
        getArticles();
      });
    }
  }

  function deleteArticle(id) {
    fetch(`https://blogpagedeploy.herokuapp.com/article/${id}`, {
      method: "DELETE",
    }).then(function () {
      document.body.innerHTML = "";
      getArticles();
    });
  }

  function clearInputs() {
    document.getElementById("modal_overlay").style.display = "block";
    let inputs = document.getElementsByClassName("input");
    console.log(inputs);
    inputs.item(0).value = "";
    inputs.item(1).value = "";
    inputs.item(2).value = "";
    inputs.item(3).value = "";
    inputs.item(4).value = "";
    inputs.item(5).value = "";

    document.getElementsByClassName("textarea").item(0).value = "";
  }

  function renderPage() {
    createHeader();
    createAddArticleButton();

    let helperArr = [...articleArray];
    let current = helperArr.slice(0, 3);
    console.log(current);
    createArticle(current);
    createFooter();
    createModal();

    container.appendChild(main);
    document.body.append(container);
  }

  renderPage();

  document
    .getElementById("add-article-button")
    .addEventListener("click", function () {
      document.getElementById("modal_overlay").style.display = "block";
    });

  document
    .getElementById("close-modal-button")
    .addEventListener("click", function () {
      document.getElementById("modal_overlay").style.display = "none";
    });

  function goToPreviousPage(parent) {
    while (parent.firstChild) {
      parent.removeChild(parent.firstChild);
    }
    var helperArray = [...articleArrayFromServer];
    var current = helperArray.slice(startingIndex - 3, startingIndex);
    startingIndex -= 3;

    console.log(startingIndex);
    console.log("PEVIOUS" + current);

    renderArticles(current);

    window.scrollTo(0, 0);

    document.getElementsByClassName("footer__link").item(1).disabled = false;
    document.getElementsByClassName("footer__link").item(1).style.color =
      "black";
  }

  function goToNextPage(parent) {
    while (parent.firstChild) {
      parent.removeChild(parent.firstChild);
    }

    var current = [];
    var helperArray = [...articleArrayFromServer];

    if (helperArray.length - startingIndex >= 3) {
      startingIndex += 3;
      current = helperArray.slice(startingIndex, startingIndex + 3);
    } else {
      helperArray.splice(0, 3);

      current = helperArray;
    }
    console.log(startingIndex);
    console.log(current);

    renderArticles(current);

    window.scrollTo(0, 0);

    document.getElementsByClassName("footer__link").item(0).disabled = false;
    document.getElementsByClassName("footer__link").item(0).style.color =
      "black";
  }
}

getArticles();
