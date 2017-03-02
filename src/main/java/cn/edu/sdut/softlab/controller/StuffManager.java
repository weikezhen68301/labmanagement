/*
 * Copyright 2016 Su Baochen and individual contributors by the 
 * @authors tag. See the copyright.txt in the distribution for
 * a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.edu.sdut.softlab.controller;

import cn.edu.sdut.softlab.model.Stuff;

import java.util.List;

public interface StuffManager {

  /**
   * 获得所有用户列表.
   *
   * @return 所有用户列表
   * @throws Exception
   */
  List<Stuff> getStuffs() throws Exception;

  /**
   * 新增用户.
   *
   * @return 返回用户列表页面
   * @throws Exception
   */
  String addStuff() throws Exception;
  String removeStuff() throws Exception;
  String modifyStuff() throws Exception;
}
