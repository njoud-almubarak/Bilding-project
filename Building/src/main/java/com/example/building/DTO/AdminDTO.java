package com.example.building.DTO;

import com.example.building.model.Account;
import com.example.building.model.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO {

      private Admin admin;
      private Account account;


}
