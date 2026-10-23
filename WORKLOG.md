# Work Log

## Phase A
> Task 1 was committed after tasks 2 and 3: I forgot to commit it
  separately at the start. The app identity changes (display name,
  bundle ID) were committed later as `task-1` on the same branch
  `phase-a-foundation` and merged into `main` with a second pull request.
> Sorry about that 🙏

### Tasks

| Task | Commit | Message | Branch |
| --- | --- | --- | --- |
| 1 | e0a2352 | task-1: set app identity and display name | phase-a-foundation |
| 2 | f90926a | task-2: architecture skeleton | phase-a-foundation |
| 3 | 48bc190 | task-3: typed content model | phase-a-foundation |

### Branches

```
❯ git branch -a 
  main
* phase-a-foundation
  phase-b-build
  remotes/origin/HEAD -> origin/main
  remotes/origin/main
  remotes/origin/phase-a-foundation
  remotes/origin/phase-b-build
```

### History

```
❯ git log --oneline --graph --decorate --all
* e0a2352 (HEAD -> phase-a-foundation, origin/phase-a-foundation) task-1: set app identity and display name
| *   873aef0 (origin/main, origin/HEAD) Merge pull request #1 from Otabek228101/phase-a-foundation
| |\  
| |/  
|/|   
* | 48bc190 (origin/phase-b-build, phase-b-build) task-3: typed content model
* | f90926a task-2: architecture skeleton
|/  
* 4d0fe31 (main) Initial commit
```