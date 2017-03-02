/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.controller;

import cn.edu.sdut.softlab.model.ItemAccount;
import java.util.List;

/**
 *
 * @author weikezhen
 */
public interface ItemAccountManager {
    List<ItemAccount> getItemAccounts() throws Exception;
    String addItemAccount() throws Exception;
}
