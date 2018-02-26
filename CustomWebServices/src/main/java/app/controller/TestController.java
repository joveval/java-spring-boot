package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.Aula;
import app.service.TestService;

@RestController
@RequestMapping(RoutingConstants.TEST_CTRL_PATH)
public class TestController {

	@Autowired
	TestService testService;

	@CrossOrigin(RoutingConstants.CORS)
	@GetMapping(RoutingConstants.TEST_CTRL_DEFAULT)
	public ResponseEntity<?> getAulaPorId(
			@RequestParam(value = RoutingConstants.PAR0101_NAME, required = RoutingConstants.PAR0101_REQ, defaultValue = RoutingConstants.PAR0101_DEF) int idAula,
			@RequestParam(value = RoutingConstants.PAR0102_NAME, required = RoutingConstants.PAR0102_REQ, defaultValue = RoutingConstants.PAR0102_DEF) Integer tipoRespuesta) {

		TipoRespuesta tResp = TipoRespuesta.values()[tipoRespuesta];

		switch (tResp) {
		case VALUE_1:
			return ResponseEntity.ok(testService.getAulaHorarioAlumnos(idAula));
		case VALUE_2:
			return ResponseEntity.badRequest().body(getErrorMessage(TipoError.BAD_REQUEST));
		default:
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getErrorMessage(TipoError.NOT_FOUND));
		}

	}

	@GetMapping(value = RoutingConstants.TEST_CTRL_CUSTOM, produces = RoutingConstants.FORMAT_TO_PRODUCE)
	public ResponseEntity<?> getAulaPorIdv2(
			@RequestParam(value = RoutingConstants.PAR0201_NAME, required = RoutingConstants.PAR0202_REQ, defaultValue = RoutingConstants.PAR0202_DEF) int idAula) {

		List<Link> links = new ArrayList<>();
		links.add(new Link(RoutingConstants.TEST_CTRL_PATH + RoutingConstants.TEST_CTRL_CUSTOM).withSelfRel());
		Resource<Aula> res = new Resource<Aula>(testService.getAulaHorarioAlumnos(idAula), links);
		return ResponseEntity.ok(res);

	}

	public static enum TipoRespuesta {
		VALUE_1(1), VALUE_2(2);
		private Integer value;

		TipoRespuesta(Integer value) {
			this.value = value;
		}

		public Integer value() {
			return this.value;
		}

	}

	public static enum TipoError {
		BAD_REQUEST(400, "Bad Request Custom"), NOT_FOUND(404, "Not Found"), INTERNAL_SERVER_ERROR(500,
				"Internal Server Error");
		private Integer status;
		private String errorMessage;

		TipoError(Integer status, String errorMessage) {
			this.status = status;
			this.errorMessage = errorMessage;
		}

		public Integer getStatus() {
			return this.status;
		}

		public String getErrorMessage() {
			return this.errorMessage;
		}
	}

	private ErrorMessage getErrorMessage(TipoError tipoError) {
		return new ErrorMessage(tipoError.getStatus(), tipoError.getErrorMessage());
	}

	public static class ErrorMessage {
		private int status;
		private String message;

		public ErrorMessage() {
		}

		public ErrorMessage(int status, String message) {
			this.status = status;
			this.message = message;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

}
