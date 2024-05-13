package vn.hoidanit.jobhunter.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vn.hoidanit.jobhunter.domain.RestResponse;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(IDInvalidException.class)
    public ResponseEntity<RestResponse<Object>> handleIDInvalidException(IDInvalidException e) {
        RestResponse<Object> res = new RestResponse<Object>();
        res.setStatusCode(HttpStatus.BAD_REQUEST.value());
        res.setMessage("invalid");
        res.setData(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
