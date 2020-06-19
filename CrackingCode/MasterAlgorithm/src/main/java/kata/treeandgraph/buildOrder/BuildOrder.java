package kata.treeandgraph.buildOrder;

import java.util.List;

public class BuildOrder {

    public Project[] orderedProjects(String[] projects, String[][] dependencies) {
        Graph graph = GraphBuilder.build(projects, dependencies);
        Project[] projectArray = new Project[projects.length];
        int index = 0;
        for (Project project : graph.projects) {
            projectArray[index++] = project;
        }
        return orderProjects(projectArray);
    }

    private Project[] orderProjects(Project[] projects) {
        Project[] order = new Project[projects.length];
        int endOfList = addNonDependentProject(projects, order, 0);
        int toBeProcessed = 0;
        while (endOfList < projects.length) {
            Project project = order[toBeProcessed];

            if (null == project) {
                return null;
            }

            List<Project> childrenList = project.children;
            Project[] children = childrenList.toArray(new Project[childrenList.size()]);
            for (Project child : children) {
                child.dependencies--;
            }
            endOfList = addNonDependentProject(children, order, endOfList);
            toBeProcessed++;
        }
        return order;
    }

    private int addNonDependentProject(Project[] projects, Project[] order, int index) {
        for (Project project : projects) {
            if (project.dependencies == 0) {
                order[index] = project;
                index++;
            }
        }
        return index;
    }
}
