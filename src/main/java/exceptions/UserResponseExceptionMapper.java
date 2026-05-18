package exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UserResponseExceptionMapper implements ExceptionMapper {
    @Override
    public Response toResponse(Throwable throwable) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity("User not found")
                .build();
    }
}
