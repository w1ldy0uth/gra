package grails.library.api

class BookService {

    static transactional = true

    def listBooks() {
        Book.list()
    }

    def addBook(Map bookDetails) {
        new Book(bookDetails).save(flush: true, failOnError: true)
    }

    def updateBook(Long id, Map bookDetails) {
        def book = Book.get(id)
        if (book) {
            book.properties = bookDetails
            book.save(flush: true, failOnError: true)
        }
    }

    def deleteBook(Long id) {
        def book = Book.get(id)
        book?.delete(flush: true)
    }

    def addRating(Long bookId, Map rating) {
        def book = Book.get(bookId)
        if (book) {
            new Rating(rating).save(flush: true, failOnError: true)

            def average = Rating.findAllByBook(book).collect { it.value }.sum() / book.ratings.size()
            book.averageRating = average
            book.save(flush: true)
        }
    }
}
