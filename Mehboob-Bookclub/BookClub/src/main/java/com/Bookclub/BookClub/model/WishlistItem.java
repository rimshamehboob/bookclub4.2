package com.Bookclub.BookClub.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class WishlistItem {
    @NotNull
    @NotEmpty(message="ISBN is required field..")
    private String isbn;
    @NotNull
    @NotEmpty(message = "TITLE is a required field")
    private String title;

    /**
     * Default constructor
     */
    public WishlistItem()
    {

    }
    public WishlistItem(String isbn,String title)
    {
        this.title = title;
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "WishlistItem{isbn "+this.getIsbn()
                +"title ="+this.getTitle()+"}";
    }
}
