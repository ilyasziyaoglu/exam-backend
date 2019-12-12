package exam.client.common.dto.pager;

import exam.client.common.dto.AbstractDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Muhammed Alagoz
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PageDto<T> extends AbstractDto {

	private static final long serialVersionUID = 1L;

	private int draw = 1;

	private int size = 10;

	private int page = 0;

	private T filterDto;

	private List<DtColumnDto> columns;

	private List<DtOrderDto> order;

	private DtSearchDto search;

}
