# Chirp User Guide
// Product screenshot goes here

Simple Chatbot to help maintain list of tasks.

## Adding todos

Tasks with deadlines can be added where the deadline of the tasks are shown to remind you of when the task is due.

Example: `todo <description>`

```
> todo review book
------------------------------------------------------------
 Added task: [T][ ] review book
 Currently 1 in the task list.
------------------------------------------------------------
```

## Adding deadlines

Tasks with deadlines can be added where the deadline of the tasks are shown to remind you of when the task is due.

Example: `deadline <description> /by <deadline>`

```
> deadline return book /by next week
------------------------------------------------------------
 Added task: [D][ ] return book  (by: next week)
 Currently 2 in the task list.
------------------------------------------------------------
```
## Adding events

Tasks with deadlines can be added where the deadline of the tasks are shown to remind you of when the task is due.

Example: `event <description> /from <start time> /to <end time>`

```
> event lecture /from morning 8:00 /to night 21:00
------------------------------------------------------------
 Added task: [E][ ] lecture (from: morning 8:00 to: night 21:00)
 Currently 3 in the task list.
------------------------------------------------------------
```

## Marking tasks

You can also mark if your tasks are done or not yet done

Example: `mark <task index>`

```
> mark 1
------------------------------------------------------------
 Modified task: [D][X] return book  (by: next week)
------------------------------------------------------------
> unmark 1
------------------------------------------------------------
 Modified task: [D][ ] return book  (by: next week)
------------------------------------------------------------
```

## Deleting tasks

You can delete tasks in the list

Example: `delete <task index>`

```
> delete 1
------------------------------------------------------------
 Delete task: [T][ ] review book
 Currently 3 tasks in the task list.
------------------------------------------------------------
```

## List Tasks

You can also lists the current tasks in the list

Example: `list`

```
> list
-----------------------------------------------------------
1. [T][ ] review book
2. [D][ ] return book  (by: next week)
3. [E][ ] lecture (from: morning 8:00 to: night 21:00)
------------------------------------------------------------
```

## Exit bot

Quit the conversation

Example: `bye`

```
> bye
------------------------------------------------------------
 Bye. Hope to see you again soon!
------------------------------------------------------------
```