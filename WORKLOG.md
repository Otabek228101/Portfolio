# Work Log

## Tasks

| Task | Commit             | Message                                                      | Branch                            |
|------|--------------------|--------------------------------------------------------------|-----------------------------------|
| 1    | e0a2352            | task-1: set app identity and display name                    | phase-a-foundation                |
| 2    | f90926a            | task-2: architecture skeleton                                | phase-a-foundation                |
| 3    | 48bc190, 6709e93   | task-3: typed content model; chore: update portfolio content | phase-a-foundation, phase-b-build |
| 4    | 2ce2040            | task-4: shared scaffold and navigation                       | phase-b-build                     |
| 5    | a4325ce            | task-5: home screen sections                                 | phase-b-build                     |
| 6    | 9e5f958            | task-6: reusable themed ProjectCard and Tag                  |  phase-b-build                    |
| 7    | a4ce2f5            | task-7: adaptive layout                                      | phase-b-build                     |
| 8    | 329854b            | task-8: light and dark theme                                 | phase-b-build                     |
| 9    | be8f084            | task-9: resources, platform polish and accessibility         | phase-c-quality                   |
| 10   | 819d181            | task-10: release build and local verification                | phase-d-ship                      |
| 11   | c1b9ea3            | task-11: CI build and GitHub Release                         | phase-d-ship                      |
| 12   | 9d81735            | task-12: README, work log and architecture defense           | phase-d-ship                      |

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
> 
## Phase D
> The first CI run failed on the iOS job: the app icon was 512×512 with transparency,
> while iOS requires 1024×1024 without alpha. Fixed in `21a438b`, after that both jobs passed.
## Branches

```
❯ git branch -a
  main
  phase-a-foundation
  phase-b-build
  phase-c-quality
* phase-d-ship
  remotes/origin/HEAD -> origin/main
  remotes/origin/main
  remotes/origin/phase-a-foundation
  remotes/origin/phase-b-build
  remotes/origin/phase-c-quality
  remotes/origin/phase-d-ship
```

## History

```
❯ git --no-pager log --oneline --graph --decorate --all
* 9d81735 (HEAD -> phase-d-ship, origin/phase-d-ship) task-12: README, work log and architecture defense
* 21a438b fix: iOS app icon must be 1024x1024 without alpha
* c25ef57 docs: add tasks 10-11 to worklog
* c1b9ea3 task-11: CI build and GitHub Release
* 819d181 task-10: release build and local verification
*   9f1e884 (origin/main, origin/HEAD, main) Merge pull request #5 from Otabek228101/phase-c-quality
|\  
| * 354c8d5 (origin/phase-c-quality, phase-c-quality) docs: add task 9 to worklog
| * be8f084 task-9: resources, platform polish and accessibility
| *   1a025c2 Merge branch 'main' into phase-c-quality
| |\  
| |/  
|/|   
* |   3e4b422 Merge pull request #4 from Otabek228101/phase-b-build
|\ \  
| | * 2a4039f docs: add task 8 to worklog
| |/  
| * 329854b (origin/phase-b-build, phase-b-build) task-8: light and dark theme
| * a4ce2f5 task-7: adaptive layout
| * 9e5f958 task-6: reusable themed ProjectCard and Tag
| * a4325ce task-5: home screen sections
| * d64231d docs: update worklog
| * 2ce2040 task-4: shared scaffold and navigation
| * 6709e93 chore: update portfolio content
|/  
*   c952729 Merge pull request #3 from Otabek228101/phase-a-foundation
|\  
| * 0670f0b (origin/phase-a-foundation, phase-a-foundation) docs: update worklog for phase A
* | bc6df72 Merge pull request #2 from Otabek228101/phase-a-foundation
|\| 
| * e0a2352 task-1: set app identity and display name
* | 873aef0 Merge pull request #1 from Otabek228101/phase-a-foundation
|\| 
| * 48bc190 task-3: typed content model
| * f90926a task-2: architecture skeleton
|/  
* 4d0fe31 Initial commit
```

