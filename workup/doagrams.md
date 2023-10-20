```mermaid
graph TD
A[Start] --> B{Do you have coffee beans?}
B --> |Yes| C[Grind the coffee beans]
B --> |No| D[Buy ground coffee beans]
C --> E[Add coffee grounds to filter]
D --> E
E --> F[Add hot water to filter]
F --> G[Enjoy!]
```


```mermaid
graph TD

subgraph Sprint Planning
    Start --> "Sprint Planning"
    "Sprint Planning" --> "Sprint Backlog"
end

subgraph Sprint
    "Sprint Backlog" --> "Daily Scrum"
    "Daily Scrum" --> "Development"
    "Development" --> "Testing"
    "Testing" --> "Sprint Review"
end

subgraph Sprint Closure
    "Sprint Review" --> "Sprint Retrospective"
    "Sprint Retrospective" --> End
end
```
