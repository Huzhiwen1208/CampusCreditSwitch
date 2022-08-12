package org.alliy.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class Applier {
    public static int appliers = 0;
    public static List<ApplyForm> applyForms = new ArrayList<>();
    public static List<ApplyForm> applyFormeds = new ArrayList<>();
}
