package com.example.exeption;


public class ResponseHandle {
	
	
	
	
	
/*	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object>ExceptionHandler (Exception ex,
			WebRequest request)throws Exception{
		
		String pat = ((ServletWebRequest)request).getRequest().getRequestURI().toString();
		String mensaje = ex.getMessage();
		int pan;
		
		
		
		if (ex instanceof HttpMediaTypeNotSupportedException) {
			HttpStatus status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
			//return new ResponseEntity<Object>(status, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		
		}
		
		else if (ex instanceof MethodArgumentNotValidException) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			
		}
		
		ErrorDto error = new ErrorDto(, "400", mensaje ,pat);
		return  ;
	
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
	//	return super.handleMethodArgumentNotValid(ex, headers, status, request);
		
		ErrorDto error = new ErrorDto("BAD_REQUEST", "400",  ex.getBindingResult().getFieldError().getDefaultMessage(),((ServletWebRequest)request).getRequest().getRequestURI().toString());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
*/
}
