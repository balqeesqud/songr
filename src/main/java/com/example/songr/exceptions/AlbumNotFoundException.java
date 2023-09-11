package com.example.songr.exceptions;

public class AlbumNotFoundException extends RuntimeException{


        public AlbumNotFoundException(String message) {
            super(message);
        }

        /*
         * Purpose: Sometimes, an exception occurs within your code that you didn't anticipate.
         * In such cases, you might want to catch that underlying exception and wrap it in your
         * custom exception to preserve information about what went wrong.
         * Usage Example: Let's say you're interacting with a database, and a SQLException is
         * thrown:
         *
         * By wrapping the SQLException in your CookieStoreNotFoundException, you maintain
         * important information about the original exception, such as the stack trace and
         * any error codes or messages provided by the database. This can be invaluable
         * for diagnosing and troubleshooting issues during development and debugging.
         */
        public AlbumNotFoundException(Throwable cause) {
            super(cause);
        }
}
