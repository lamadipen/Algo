package kata.treeandgraph.buildOrder;

import org.junit.Test;

import java.util.Arrays;

public class BuildOrderTest {

    @Test
    public void orderedProjectsTest() {
        BuildOrder buildOrder = new BuildOrder();
        String[] projects = new String[]{"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = new String[5][2];
        dependencies[0] = new String[]{"a", "d"};
        dependencies[1] = new String[]{"f", "b"};
        dependencies[2] = new String[]{"b", "d"};
        dependencies[3] = new String[]{"f", "a"};
        dependencies[4] = new String[]{"d", "c"};

        Project[] actual = buildOrder.orderedProjects(projects, dependencies);

        Arrays.stream(actual).forEach(item -> System.out.print(item.name + " -> "));
    }

}