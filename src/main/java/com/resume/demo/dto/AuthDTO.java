
package com.resume.demo.dto;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AuthDTO {

    private String username;
    private String password;

}