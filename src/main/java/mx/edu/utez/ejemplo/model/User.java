package mx.edu.utez.ejemplo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank(message = "Este campo no puede estar vacio")
    @Size(max = 20,message = "No puede ser mayor a 20 caracteres")
    private String nombre;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Size(max = 30,message = "No puede ser mayor a 30 caracteres")
    private String primerApellido;

    @Size(max = 30,message ="No puede ser mayor a 30 caracteres" )
    private String segundoApellido;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Size(min = 12,max = 13,message ="El RFC debe de tener entre 12 y 13 caracteres")
    private String rfc;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Size(min = 10,max = 10,message = "No puede ser mayor a 10 caracteres")
    private String telefono;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Size(max = 30,message = "No puede ser mayor a 60 caracteres")
    @Email(message = "El correo debe de cumplir con el formato requerido")
    private String correoElectronico;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Size(max =8 ,message ="No puede ser mayor a 20 caracteres" )
    private String contrasena;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
