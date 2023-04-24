package com.Bookclub.BookClub.service.impl;

import com.Bookclub.BookClub.model.WishlistItem;
import com.Bookclub.BookClub.service.dao.WishlistDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemWishlistDao implements WishlistDao {

    private List<WishlistItem> wishlistItemList;
    public MemWishlistDao() {
        this.wishlistItemList = new ArrayList<>();

        for(int x=0;x<5;x++)
        {
            WishlistItem w_item = new WishlistItem();
            w_item.setIsbn("ISBN-#001");
            w_item.setTitle("BOOK-title");

            this.wishlistItemList.add(w_item);

        }
    }
    @Override
    public List list() {
        return this.wishlistItemList;
    }

    @Override
    public WishlistItem find(String key) {
        return null;
    }


}
