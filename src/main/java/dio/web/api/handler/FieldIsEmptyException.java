package dio.web.api.handler;

public class FieldIsEmptyException extends BusinessException {
    public FieldIsEmptyException(String field) {
        super("The %s field cannot be empty", field);
    }
}
