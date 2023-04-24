
package com.Bookclub.BookClub.web;
import com.Bookclub.BookClub.service.impl.MemWishlistDao;
import com.Bookclub.BookClub.model.WishlistItem;
import com.Bookclub.BookClub.service.dao.WishlistDao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
@RequestMapping("/wishlist")
public class WishlistController {
    @Autowired
    private MemWishlistDao wishlistDao;

    @RequestMapping(method= RequestMethod.GET)
    public String showWishlist(Model model)
    {
        List<WishlistItem> wishlist = wishlistDao.list();
        model.addAttribute("wishlist",wishlist);
        return "wishlist/list";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/new")
    public String wishlistForm(Model model)
    {
        WishlistItem wishlistItem = new WishlistItem();
        model.addAttribute("wishlistItem",wishlistItem);
        return "wishlist/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult)
    {
        System.out.println(wishlistItem.toString());

        System.out.println(bindingResult.getAllErrors());

        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }

        return "redirect:/wishlist";
    }
}
