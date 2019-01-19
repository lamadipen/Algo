package com.dp.cci.graphandtrees;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by dipen on 1/19/2019.
 */
@Builder
@Getter
public class Node {
    private int data;
    @Setter
    private List<Node> adjacent;
}