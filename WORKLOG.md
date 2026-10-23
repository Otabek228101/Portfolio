# Work Log

## Tasks

| Task | Commit | Message                                                      | Branch |
|------| --- |--------------------------------------------------------------| --- |
| 1    | e0a2352 | task-1: set app identity and display name                    | phase-a-foundation |
| 2    | f90926a | task-2: architecture skeleton                                | phase-a-foundation |
| 3    | 48bc190, 6709e93 | task-3: typed content model; chore: update portfolio content | phase-a-foundation, phase-b-build |
| 4    | 2ce2040 | task-4: shared scaffold and navigation                       | phase-b-build |
| 5    | a4325ce | task-5: home screen sections                                 | phase-b-build |
| 6    | 9e5f958 | task-6: reusable themed ProjectCard and Tag                             | phase-b-build |
| 7    | a4ce2f5 | task-7: adaptive layout                          | phase-b-build |
## Phase A
> Task 1 was committed after tasks 2 and 3: I forgot to commit it
>  separately at the start. The app identity changes (display name,
>  bundle ID) were committed later as `task-1` on the same branch
>  `phase-a-foundation` and merged into `main` with a second pull request.

>  The real code for task 3 was missing from the first `task-3` commit
> (only placeholders were committed). It was committed later as
> `6709e93` on `phase-b-build`.

> Sorry about that 🙏(when I started doing the tasks, I didn't pay attention to the need to commit)

## Phase B
>for task 7, I made screenshots in docs/screenshots/

## Branches

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

## History

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

