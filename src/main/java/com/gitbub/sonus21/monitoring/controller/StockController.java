/*
 * Copyright (c) Sonu Kumar
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.gitbub.sonus21.monitoring.controller;

import com.gitbub.sonus21.monitoring.service.StockManager;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "stocks")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StockController {
  @NonNull private StockManager stockManager;

  @GetMapping
  @ResponseBody
  public List<String> getItems(@RequestParam int size) {
    return stockManager.getItem(size);
  }

  @PostMapping
  @ResponseBody
  public int addItems(@RequestParam List<String> items) {
    stockManager.addItems(items);
    return stockManager.getNumberOfItems();
  }
}
