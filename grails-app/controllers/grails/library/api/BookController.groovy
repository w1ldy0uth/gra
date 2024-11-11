package grails.library.api

class BookController {

    BookService bookService

    // List all books
    def list() {
        respond books: bookService.listBooks()
    }

    // Save a new book
    def save() {
        def json = request.JSON
        bookService.addBook(json)
        respond book: json, status: 201
    }

    // Update an existing book
    def update(Long id) {
        def json = request.JSON
        bookService.updateBook(id, json)
        respond book: json, status: 200
    }

    // Delete an existing book
    def delete(Long id) {
        bookService.deleteBook(id)
        respond status: 200
    }

    // Rate an existing book
    def addRating(Long bookId) {
        def json = request.JSON
        bookService.addRating(bookId, json.value)
        respond status: 200
    }
}
