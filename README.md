https://blogpagedeploy.herokuapp.com/fe/index.html

GET ARTICLES including pagination (three at a time): https://blogpagedeploy.herokuapp.com/articles https://blogpagedeploy.herokuapp.com/articles?page=0

GET ONE BY ID - https://blogpagedeploy.herokuapp.com/articles/1

POST - https://blogpagedeploy.herokuapp.com/articles

{ "title": "The complete guide to explore Trasilvania, with your bike", "tag": "Destination Europe", "author": "Jolika Sulejmani", "date": "July 10, 2021", "imageURL": "img/bike.jpg", "content": "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Est totam laboriosam debitis magnam voluptatum, incidunt neque. Totam ullam non quis, repellendus molestiae in itaque natus labore quos ipsum alias, veritatis nihil! Quisquam labore, sequi minima expedita necessitatibus omnis error amet recusandae atque commodi quia! Vel laborum recusandae voluptatum rerum id harum, fuga beatae ut, consequuntur repellendus ipsum temporibus libero itaque. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde quod tempore quaerat deserunt. Voluptatibus possimus, magni quas rem adipisci, esse ipsa fuga, fugit eos repellendus quis? Dicta perferendis, doloremque provident repellendus natus fugit obcaecati, voluptate odio, nulla similique officia. Iure at aliquam dicta provident nulla modi optio maiores. Similique eos molestiae earum voluptatum nostrum porro, consequuntur nihil ex earum. Voluptatum placeat labore necessitatibus repellat. Repudiandae velit suscipit amet tenetur, mollitia aut dolor ipsa delectus a autem ut quibusdam incidunt? Nisi facilis voluptatem omnis debitis laborum cupiditate pariatur inventore molestiae eveniet!", "saying": "Life is like riding a bicycle, to keep your balance you must keep moving", "dateTimestamp": "2021-09-17T08:26:35.000+00:00" }

{ "title": "Bucegi: Places you must visit before you die", "tag": "Must Visit", "author": "Jonnathan Mercadina", "date": "June 30, 2018", "imageURL": "img/bucegi.jpg", "content": "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Est totam laboriosam debitis magnam voluptatum, incidunt neque. Totam ullam non quis, repellendus molestiae in itaque natus labore quos ipsum alias, veritatis nihil! Quisquam labore, sequi minima expedita necessitatibus omnis error amet recusandae atque commodi quia! Vel laborum recusandae voluptatum rerum id harum, fuga beatae ut, consequuntur repellendus ipsum temporibus libero itaque. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde quod tempore quaerat deserunt. Voluptatibus possimus, magni quas rem adipisci, esse ipsa fuga, fugit eos repellendus quis? Dicta perferendis, doloremque provident repellendus natus fugit obcaecati, voluptate odio, nulla similique officia. Iure at aliquam dicta provident nulla modi optio maiores. Similique eos molestiae earum voluptatum nostrum porro, consequuntur nihil ex earum. Voluptatum placeat labore necessitatibus repellat. Repudiandae velit suscipit amet tenetur, mollitia aut dolor ipsa delectus a autem ut quibusdam incidunt? Nisi facilis voluptatem omnis debitis laborum cupiditate pariatur inventore molestiae eveniet!", "saying": "My spirit soars where the air goes thin.", "dateTimestamp": "2021-09-17T08:26:35.000+00:00" }

{ "title": "Romania: The land of dreams", "tag": "Village", "author": "Jonnathan Mercadina", "date": "June 17, 2018", "imageURL": "img/village.jpg", "content": "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Est totam laboriosam debitis magnam voluptatum, incidunt neque. Totam ullam non quis, repellendus molestiae in itaque natus labore quos ipsum alias, veritatis nihil! Quisquam labore, sequi minima expedita necessitatibus omnis error amet recusandae atque commodi quia! Vel laborum recusandae voluptatum rerum id harum, fuga beatae ut, consequuntur repellendus ipsum temporibus libero itaque. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde quod tempore quaerat deserunt. Voluptatibus possimus, magni quas rem adipisci, esse ipsa fuga, fugit eos repellendus quis? Dicta perferendis, doloremque provident repellendus natus fugit obcaecati, voluptate odio, nulla similique officia. Iure at aliquam dicta provident nulla modi optio maiores. Similique eos molestiae earum voluptatum nostrum porro, consequuntur nihil ex earum. Voluptatum placeat labore necessitatibus repellat. Repudiandae velit suscipit amet tenetur, mollitia aut dolor ipsa delectus a autem ut quibusdam incidunt? Nisi facilis voluptatem omnis debitis laborum cupiditate pariatur inventore molestiae eveniet!", "saying": "Life is not worth living if it is lived kneeling in front of others.", "dateTimestamp": "2021-09-17T08:26:35.000+00:00" }

PUT - https://blogpagedeploy.herokuapp.com/articles/20{"title": "UPDATE","tag": "UPDATE","author": "UPDATE","date": "UPDATE","imageURL": "UPDATE","content": "UPDATE","dateTimestamp":"2021-09-17T08:26:35.307+00:00"}

GET IMAGE - https://blogpagedeploy.herokuapp.com/img/bike.jpg

Searching with combined or single filters - https://blogpagedeploy.herokuapp.com/articles?author=Jolikahttps://blogpagedeploy.herokuapp.com/articles?author=Jolika?title=z (No data for the combination of these contents)

LOGIN: The password is the same as the username for all the users created.

http://localhost:8080/api/auth/signup { "firstName": "Tea", "lastName": "Sulejmani", "password": "tea", "username": "tea" }

http://localhost:8080/api/auth/signin { "password": "tea", "username": "tea" }

A token of type "Bearer" is generated and returned as a response together with some other info.


--------------------------------------------------------------------------------------------------------------

SWAGGER: http://localhost:8080/swagger-ui.html#/article-controller

{
"swagger": "2.0",
"info": {
"description": "Api Documentation",
"version": "1.0",
"title": "Api Documentation",
"termsOfService": "urn:tos",
"contact": {},
"license": {
"name": "Apache 2.0",
"url": "http://www.apache.org/licenses/LICENSE-2.0"
}
},
"host": "localhost:8080",
"basePath": "/",
"tags": [
{
"name": "article-controller",
"description": "Article Controller"
},
{
"name": "basic-error-controller",
"description": "Basic Error Controller"
}
],
"paths": {
"/": {
"get": {
"tags": [
"article-controller"
],
"summary": "home",
"operationId": "homeUsingGET",
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "string"
}
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
},
"404": {
"description": "Not Found"
}
}
},
"head": {
"tags": [
"article-controller"
],
"summary": "home",
"operationId": "homeUsingHEAD",
"consumes": [
"application/json"
],
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "string"
}
},
"204": {
"description": "No Content"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
}
}
},
"post": {
"tags": [
"article-controller"
],
"summary": "home",
"operationId": "homeUsingPOST",
"consumes": [
"application/json"
],
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "string"
}
},
"201": {
"description": "Created"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
},
"404": {
"description": "Not Found"
}
}
},
"put": {
"tags": [
"article-controller"
],
"summary": "home",
"operationId": "homeUsingPUT",
"consumes": [
"application/json"
],
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "string"
}
},
"201": {
"description": "Created"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
},
"404": {
"description": "Not Found"
}
}
},
"delete": {
"tags": [
"article-controller"
],
"summary": "home",
"operationId": "homeUsingDELETE",
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "string"
}
},
"204": {
"description": "No Content"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
}
}
},
"options": {
"tags": [
"article-controller"
],
"summary": "home",
"operationId": "homeUsingOPTIONS",
"consumes": [
"application/json"
],
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "string"
}
},
"204": {
"description": "No Content"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
}
}
},
"patch": {
"tags": [
"article-controller"
],
"summary": "home",
"operationId": "homeUsingPATCH",
"consumes": [
"application/json"
],
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "string"
}
},
"204": {
"description": "No Content"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
}
}
}
},
"/articles": {
"get": {
"tags": [
"article-controller"
],
"summary": "findArticles",
"operationId": "findArticlesUsingGET",
"produces": [
"*/*"
],
"parameters": [
{
"name": "author",
"in": "query",
"description": "author",
"required": false,
"type": "string"
},
{
"name": "content",
"in": "query",
"description": "content",
"required": false,
"type": "string"
},
{
"name": "date",
"in": "query",
"description": "date",
"required": false,
"type": "string"
},
{
"name": "page",
"in": "query",
"description": "page",
"required": false,
"type": "integer",
"default": 0,
"format": "int32"
},
{
"name": "tag",
"in": "query",
"description": "tag",
"required": false,
"type": "string"
},
{
"name": "title",
"in": "query",
"description": "title",
"required": false,
"type": "string"
}
],
"responses": {
"200": {
"description": "OK",
"schema": {
"$ref": "#/definitions/ResponseEntity"
}
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
},
"404": {
"description": "Not Found"
}
}
},
"post": {
"tags": [
"article-controller"
],
"summary": "insertArticle",
"operationId": "insertArticleUsingPOST",
"consumes": [
"application/json"
],
"produces": [
"*/*"
],
"parameters": [
{
"in": "body",
"name": "article",
"description": "article",
"required": true,
"schema": {
"$ref": "#/definitions/Article"
}
}
],
"responses": {
"200": {
"description": "OK",
"schema": {
"$ref": "#/definitions/ResponseEntity"
}
},
"201": {
"description": "Created"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
},
"404": {
"description": "Not Found"
}
}
}
},
"/articles/count": {
"get": {
"tags": [
"article-controller"
],
"summary": "getNumberOfArticles",
"operationId": "getNumberOfArticlesUsingGET",
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"$ref": "#/definitions/ResponseEntity"
}
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
},
"404": {
"description": "Not Found"
}
}
}
},
"/articles/{articleId}": {
"get": {
"tags": [
"article-controller"
],
"summary": "getArticleById",
"operationId": "getArticleByIdUsingGET",
"produces": [
"*/*"
],
"parameters": [
{
"name": "articleId",
"in": "path",
"description": "articleId",
"required": true,
"type": "integer",
"format": "int32"
},
{
"name": "includeNews",
"in": "query",
"description": "includeNews",
"required": false,
"type": "boolean",
"default": false
}
],
"responses": {
"200": {
"description": "OK",
"schema": {
"$ref": "#/definitions/ResponseEntity"
}
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
},
"404": {
"description": "Not Found"
}
}
},
"put": {
"tags": [
"article-controller"
],
"summary": "updateArticle",
"operationId": "updateArticleUsingPUT",
"consumes": [
"application/json"
],
"produces": [
"*/*"
],
"parameters": [
{
"in": "body",
"name": "article",
"description": "article",
"required": true,
"schema": {
"$ref": "#/definitions/Article"
}
},
{
"name": "articleId",
"in": "path",
"description": "articleId",
"required": true,
"type": "integer",
"format": "int32"
}
],
"responses": {
"200": {
"description": "OK",
"schema": {
"$ref": "#/definitions/ResponseEntity"
}
},
"201": {
"description": "Created"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
},
"404": {
"description": "Not Found"
}
}
},
"delete": {
"tags": [
"article-controller"
],
"summary": "deleteArticleById",
"operationId": "deleteArticleByIdUsingDELETE",
"produces": [
"*/*"
],
"parameters": [
{
"name": "articleId",
"in": "path",
"description": "articleId",
"required": true,
"type": "integer",
"format": "int32"
}
],
"responses": {
"200": {
"description": "OK",
"schema": {
"$ref": "#/definitions/ResponseEntity"
}
},
"204": {
"description": "No Content"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
}
}
}
},
"/error": {
"get": {
"tags": [
"basic-error-controller"
],
"summary": "error",
"operationId": "errorUsingGET",
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "object",
"additionalProperties": {
"type": "object"
}
}
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
},
"404": {
"description": "Not Found"
}
}
},
"head": {
"tags": [
"basic-error-controller"
],
"summary": "error",
"operationId": "errorUsingHEAD",
"consumes": [
"application/json"
],
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "object",
"additionalProperties": {
"type": "object"
}
}
},
"204": {
"description": "No Content"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
}
}
},
"post": {
"tags": [
"basic-error-controller"
],
"summary": "error",
"operationId": "errorUsingPOST",
"consumes": [
"application/json"
],
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "object",
"additionalProperties": {
"type": "object"
}
}
},
"201": {
"description": "Created"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
},
"404": {
"description": "Not Found"
}
}
},
"put": {
"tags": [
"basic-error-controller"
],
"summary": "error",
"operationId": "errorUsingPUT",
"consumes": [
"application/json"
],
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "object",
"additionalProperties": {
"type": "object"
}
}
},
"201": {
"description": "Created"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
},
"404": {
"description": "Not Found"
}
}
},
"delete": {
"tags": [
"basic-error-controller"
],
"summary": "error",
"operationId": "errorUsingDELETE",
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "object",
"additionalProperties": {
"type": "object"
}
}
},
"204": {
"description": "No Content"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
}
}
},
"options": {
"tags": [
"basic-error-controller"
],
"summary": "error",
"operationId": "errorUsingOPTIONS",
"consumes": [
"application/json"
],
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "object",
"additionalProperties": {
"type": "object"
}
}
},
"204": {
"description": "No Content"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
}
}
},
"patch": {
"tags": [
"basic-error-controller"
],
"summary": "error",
"operationId": "errorUsingPATCH",
"consumes": [
"application/json"
],
"produces": [
"*/*"
],
"responses": {
"200": {
"description": "OK",
"schema": {
"type": "object",
"additionalProperties": {
"type": "object"
}
}
},
"204": {
"description": "No Content"
},
"401": {
"description": "Unauthorized"
},
"403": {
"description": "Forbidden"
}
}
}
}
},
"definitions": {
"Article": {
"type": "object",
"properties": {
"author": {
"type": "string"
},
"content": {
"type": "string"
},
"date": {
"type": "string"
},
"dateTimestamp": {
"$ref": "#/definitions/Timestamp"
},
"id": {
"type": "integer",
"format": "int32"
},
"imageURL": {
"type": "string"
},
"saying": {
"type": "string"
},
"tag": {
"type": "string"
},
"title": {
"type": "string"
}
},
"title": "Article"
},
"ModelAndView": {
"type": "object",
"properties": {
"empty": {
"type": "boolean"
},
"model": {
"type": "object"
},
"modelMap": {
"type": "object",
"additionalProperties": {
"type": "object"
}
},
"reference": {
"type": "boolean"
},
"status": {
"type": "string",
"enum": [
"ACCEPTED",
"ALREADY_REPORTED",
"BAD_GATEWAY",
"BAD_REQUEST",
"BANDWIDTH_LIMIT_EXCEEDED",
"CHECKPOINT",
"CONFLICT",
"CONTINUE",
"CREATED",
"DESTINATION_LOCKED",
"EXPECTATION_FAILED",
"FAILED_DEPENDENCY",
"FORBIDDEN",
"FOUND",
"GATEWAY_TIMEOUT",
"GONE",
"HTTP_VERSION_NOT_SUPPORTED",
"IM_USED",
"INSUFFICIENT_SPACE_ON_RESOURCE",
"INSUFFICIENT_STORAGE",
"INTERNAL_SERVER_ERROR",
"I_AM_A_TEAPOT",
"LENGTH_REQUIRED",
"LOCKED",
"LOOP_DETECTED",
"METHOD_FAILURE",
"METHOD_NOT_ALLOWED",
"MOVED_PERMANENTLY",
"MOVED_TEMPORARILY",
"MULTIPLE_CHOICES",
"MULTI_STATUS",
"NETWORK_AUTHENTICATION_REQUIRED",
"NON_AUTHORITATIVE_INFORMATION",
"NOT_ACCEPTABLE",
"NOT_EXTENDED",
"NOT_FOUND",
"NOT_IMPLEMENTED",
"NOT_MODIFIED",
"NO_CONTENT",
"OK",
"PARTIAL_CONTENT",
"PAYLOAD_TOO_LARGE",
"PAYMENT_REQUIRED",
"PERMANENT_REDIRECT",
"PRECONDITION_FAILED",
"PRECONDITION_REQUIRED",
"PROCESSING",
"PROXY_AUTHENTICATION_REQUIRED",
"REQUESTED_RANGE_NOT_SATISFIABLE",
"REQUEST_ENTITY_TOO_LARGE",
"REQUEST_HEADER_FIELDS_TOO_LARGE",
"REQUEST_TIMEOUT",
"REQUEST_URI_TOO_LONG",
"RESET_CONTENT",
"SEE_OTHER",
"SERVICE_UNAVAILABLE",
"SWITCHING_PROTOCOLS",
"TEMPORARY_REDIRECT",
"TOO_EARLY",
"TOO_MANY_REQUESTS",
"UNAUTHORIZED",
"UNAVAILABLE_FOR_LEGAL_REASONS",
"UNPROCESSABLE_ENTITY",
"UNSUPPORTED_MEDIA_TYPE",
"UPGRADE_REQUIRED",
"URI_TOO_LONG",
"USE_PROXY",
"VARIANT_ALSO_NEGOTIATES"
]
},
"view": {
"$ref": "#/definitions/View"
},
"viewName": {
"type": "string"
}
},
"title": "ModelAndView"
},
"ResponseEntity": {
"type": "object",
"properties": {
"body": {
"type": "object"
},
"statusCode": {
"type": "string",
"enum": [
"ACCEPTED",
"ALREADY_REPORTED",
"BAD_GATEWAY",
"BAD_REQUEST",
"BANDWIDTH_LIMIT_EXCEEDED",
"CHECKPOINT",
"CONFLICT",
"CONTINUE",
"CREATED",
"DESTINATION_LOCKED",
"EXPECTATION_FAILED",
"FAILED_DEPENDENCY",
"FORBIDDEN",
"FOUND",
"GATEWAY_TIMEOUT",
"GONE",
"HTTP_VERSION_NOT_SUPPORTED",
"IM_USED",
"INSUFFICIENT_SPACE_ON_RESOURCE",
"INSUFFICIENT_STORAGE",
"INTERNAL_SERVER_ERROR",
"I_AM_A_TEAPOT",
"LENGTH_REQUIRED",
"LOCKED",
"LOOP_DETECTED",
"METHOD_FAILURE",
"METHOD_NOT_ALLOWED",
"MOVED_PERMANENTLY",
"MOVED_TEMPORARILY",
"MULTIPLE_CHOICES",
"MULTI_STATUS",
"NETWORK_AUTHENTICATION_REQUIRED",
"NON_AUTHORITATIVE_INFORMATION",
"NOT_ACCEPTABLE",
"NOT_EXTENDED",
"NOT_FOUND",
"NOT_IMPLEMENTED",
"NOT_MODIFIED",
"NO_CONTENT",
"OK",
"PARTIAL_CONTENT",
"PAYLOAD_TOO_LARGE",
"PAYMENT_REQUIRED",
"PERMANENT_REDIRECT",
"PRECONDITION_FAILED",
"PRECONDITION_REQUIRED",
"PROCESSING",
"PROXY_AUTHENTICATION_REQUIRED",
"REQUESTED_RANGE_NOT_SATISFIABLE",
"REQUEST_ENTITY_TOO_LARGE",
"REQUEST_HEADER_FIELDS_TOO_LARGE",
"REQUEST_TIMEOUT",
"REQUEST_URI_TOO_LONG",
"RESET_CONTENT",
"SEE_OTHER",
"SERVICE_UNAVAILABLE",
"SWITCHING_PROTOCOLS",
"TEMPORARY_REDIRECT",
"TOO_EARLY",
"TOO_MANY_REQUESTS",
"UNAUTHORIZED",
"UNAVAILABLE_FOR_LEGAL_REASONS",
"UNPROCESSABLE_ENTITY",
"UNSUPPORTED_MEDIA_TYPE",
"UPGRADE_REQUIRED",
"URI_TOO_LONG",
"USE_PROXY",
"VARIANT_ALSO_NEGOTIATES"
]
},
"statusCodeValue": {
"type": "integer",
"format": "int32"
}
},
"title": "ResponseEntity"
},
"Timestamp": {
"type": "object",
"properties": {
"date": {
"type": "integer",
"format": "int32"
},
"hours": {
"type": "integer",
"format": "int32"
},
"minutes": {
"type": "integer",
"format": "int32"
},
"month": {
"type": "integer",
"format": "int32"
},
"nanos": {
"type": "integer",
"format": "int32"
},
"seconds": {
"type": "integer",
"format": "int32"
},
"time": {
"type": "integer",
"format": "int64"
},
"year": {
"type": "integer",
"format": "int32"
}
},
"title": "Timestamp"
},
"View": {
"type": "object",
"properties": {
"contentType": {
"type": "string"
}
},
"title": "View"
}
}
}