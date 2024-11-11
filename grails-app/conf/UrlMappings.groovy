class UrlMappings {

    static mappings = {
        "/"(view:"/index")
        "500"(view:'/error')
        "/books"(controller: 'book') {
            action = [GET: "list", POST: "save"]
        }
        "/books/$id"(controller: 'book') {
            action = [PUT: "update", DELETE: "delete"]
        }
        "/books/$bookId/rate"(controller: 'book', action: 'addRating') {
            method = "POST"
        }
    }
}
