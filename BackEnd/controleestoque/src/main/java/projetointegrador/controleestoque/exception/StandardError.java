package projetointegrador.controleestoque.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class StandardError {

    private Instant timestap;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() { }

    public StandardError(Instant timestap, Integer status, String error, String message, String path) {
        this.timestap = timestap;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
