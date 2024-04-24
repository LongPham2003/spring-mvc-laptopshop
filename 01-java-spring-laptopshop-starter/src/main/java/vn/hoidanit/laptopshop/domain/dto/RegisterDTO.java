package vn.hoidanit.laptopshop.domain.dto;

import jakarta.validation.constraints.Size;
import vn.hoidanit.laptopshop.service.validator.RegisterChecked;

@RegisterChecked
public class RegisterDTO {
    @Size(min = 3, message = "Phải có tối thiểu 3 kí tự")
    private String firstName;
    @Size(min = 3, message = "Phải có tối thiểu 3 kí tự")
    private String lastName;
    @Size(min = 3, message = "Phải có tối thiểu 3 kí tự")
    private String email;
    private String password;
    @Size(min = 3, message = "Phải có tối thiểu 3 kí tự")

    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
