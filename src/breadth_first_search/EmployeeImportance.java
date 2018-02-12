package breadth_first_search;

import java.util.*;

public class EmployeeImportance {

    //TAG: Uber
    //TAG: DFS
    //TAG: Breath first search

    /**
     * 690. Employee Importance
     * You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

     For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

     Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.

     Example 1:
     Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
     Output: 11
     Explanation:
     Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
     Note:
     One employee has at most one direct leader and may have several subordinates.
     The maximum number of employees won't exceed 2000.
     */

    /**
     * Solution (DFS):
     *
     */

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee: employees) map.put(employee.id, employee);
        int[] res = new int[]{0};
        //Set is used when one has multi supervisors, not fit for this question
        Set<Integer> set = new HashSet<>();
        getImportanceHelper(map.get(id), res, map, set);
        return res[0];
    }

    private void getImportanceHelper(Employee employee, int[] res, Map<Integer, Employee> map, Set<Integer> set) {
        if (set.add(employee.id)) {
            res[0] += employee.importance;
            for (int i = 0; i < employee.subordinates.size(); i++) {
                Employee sub = map.get(employee.subordinates.get(i));
                getImportanceHelper(sub, res, map, set);
            }
        }
    }

    /**
     * Solution (BFS):
     */

    public int getImportanceS2(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee: employees) map.put(employee.id, employee);
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int res = 0;
        while (!queue.isEmpty()) {
            Employee poll = queue.poll();
            res += poll.importance;
            for (int i = 0; i < poll.subordinates.size(); i++) {
                queue.offer(map.get(poll.subordinates.get(i)));
            }
        }
        return res;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

}
