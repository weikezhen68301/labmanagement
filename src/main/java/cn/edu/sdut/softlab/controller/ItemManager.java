/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.controller;

import cn.edu.sdut.softlab.model.Item;
import java.util.List;

/**
 *
 * @author weikezhen
 */
public interface ItemManager {
    List<Item> getItems() throws Exception;

    /**
     * - 
     * @return
     * @throws Exception
     */
    String addItem() throws Exception;
    String removeItem() throws Exception;
    String rentalItem() throws Exception;
    String returnItem() throws Exception;
}
