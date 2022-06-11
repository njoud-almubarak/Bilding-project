package com.example.building.DTO;

import com.example.building.model.Account;
import com.example.building.model.ServiceProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpDTO {

      private ServiceProvider serviceProvider;
      private Account account;
}
