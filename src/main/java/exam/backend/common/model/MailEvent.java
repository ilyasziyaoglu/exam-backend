package exam.backend.common.model;

import lombok.Data;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class MailEvent implements Serializable {

	private String subject;

	private String to;

	private String from;

	private String vm;

	private Map<String, Object> dataModel = new HashMap<>();

	private List<File> files = new ArrayList<>();

	private String fileName;

	private String bcc;

	private String cc;
}
