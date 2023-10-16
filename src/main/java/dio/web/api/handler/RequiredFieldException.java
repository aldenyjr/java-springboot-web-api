package dio.web.api.handler;

public class RequiredFieldException extends BusinessException {
    public RequiredFieldException(String field) {
        super("The field is %s required", field);
    }
}
