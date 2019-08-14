package com.company;

import com.company.libraryFiles.LibraryOperations;


public class Main {

    public static void main(String[] args) {
        LibraryOperations libop =new LibraryOperations();
        libop.showNewFilms();
        libop.showFilmInformation();
        libop.showActorsWithManyRoles();
        libop.actorsAsDirectors();
        libop.deleteOldFilms(35);
    }
}
