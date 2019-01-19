package com.dp.cci.graphandtrees;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * Created by dipen on 1/19/2019.
 */
@Builder
@Getter
public class Graph {
    private List<Node> nodes;
}

