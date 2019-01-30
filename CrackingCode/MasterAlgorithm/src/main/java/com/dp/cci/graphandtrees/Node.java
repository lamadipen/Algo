package com.dp.cci.graphandtrees;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by dipen on 1/19/2019.
 */
@Builder
public class Node {
    @Getter
    private int data;
    @Setter
    @Getter
    private List<Node> adjacent;
}