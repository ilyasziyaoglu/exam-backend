package exam.client.common.dto.pager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtSearchDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String value;

    private Boolean regex;

}