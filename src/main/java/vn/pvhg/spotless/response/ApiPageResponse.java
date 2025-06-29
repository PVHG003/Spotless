package vn.pvhg.spotless.response;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Getter
@SuperBuilder
public class ApiPageResponse<T> extends ApiResponse<T> {
    private int page;
    private int size;
    private int totalPages;
    private long totalElements;

    public static <T> ApiPageResponse<T> ok(int page, int size, int totalPages, int totalElements, T data) {
        return ApiPageResponse.<T>builder()
                .code(HttpStatus.OK.value())
                .success(true)
                .message("Success")
                .page(page)
                .size(size)
                .totalPages(totalPages)
                .totalElements(totalElements)
                .data(data)
                .build();
    }
}
