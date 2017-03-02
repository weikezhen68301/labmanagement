/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.controller;

import cn.edu.sdut.softlab.model.Category;
import java.util.List;

/**
 *
 * @author weikezhen
 */
public interface CategoryManager {
    List<Category> getCategorys() throws Exception;
    String addCategory() throws Exception;
}
