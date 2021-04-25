package ingjulianvega.ximic.msscasudisabilitytype.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisabilityTypeList implements Serializable {

    static final long serialVersionUID = -1561918952202274728L;

    public ArrayList<DisabilityTypeDto> bodyPartList;
}
