package vn.pvhg.spotless.response;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Getter
@SuperBuilder
public class ApiResponse<T> {
    private int code;
    private boolean success;
    private String message;
    private T data;

    // 200 OK
    public static <T> ApiResponse<T> ok(String message, T data) {
        return ApiResponse.<T>builder()
                .code(HttpStatus.OK.value())
                .success(true)
                .message(message == null ? "Success" : message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> ok() {
        return ok(null, null);
    }

    public static <T> ApiResponse<T> ok(T data) {
        return ok(null, data);
    }

    // 201 Created
    public static <T> ApiResponse<T> created(String message, T data) {
        return ApiResponse.<T>builder()
                .code(HttpStatus.CREATED.value())
                .success(true)
                .message(message == null ? "Created" : message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> created() {
        return created(null, null);
    }

    public static <T> ApiResponse<T> created(T data) {
        return created(null, data);
    }

    // 204 No Content
    public static <T> ApiResponse<T> noContent(String message) {
        return ApiResponse.<T>builder()
                .code(HttpStatus.NO_CONTENT.value())
                .success(true)
                .message(message == null ? "No Content" : message)
                .build();
    }

    public static <T> ApiResponse<T> noContent() {
        return noContent(null);
    }

    // 400 Bad Request
    public static <T> ApiResponse<T> badRequest(String message) {
        return ApiResponse.<T>builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .success(false)
                .message(message == null ? "Bad Request" : message)
                .build();
    }

    // 401 Unauthorized
    public static <T> ApiResponse<T> unauthorized(String message) {
        return ApiResponse.<T>builder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .success(false)
                .message(message == null ? "Unauthorized" : message)
                .build();
    }

    // 403 Forbidden
    public static <T> ApiResponse<T> forbidden(String message) {
        return ApiResponse.<T>builder()
                .code(HttpStatus.FORBIDDEN.value())
                .success(false)
                .message(message == null ? "Forbidden" : message)
                .build();
    }

    // 404 Not Found
    public static <T> ApiResponse<T> notFound(String message) {
        return ApiResponse.<T>builder()
                .code(HttpStatus.NOT_FOUND.value())
                .success(false)
                .message(message == null ? "Not Found" : message)
                .build();
    }

    // 500 Internal Server Error
    public static <T> ApiResponse<T> internalServerError(String message) {
        return ApiResponse.<T>builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .success(false)
                .message(message == null ? "Internal Server Error" : message)
                .build();
    }

    // Generic error with custom status
    public static <T> ApiResponse<T> error(HttpStatus status, String message) {
        return ApiResponse.<T>builder()
                .code(status.value())
                .success(false)
                .message(message)
                .build();
    }
}
