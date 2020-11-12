# GetPut Adventures (web)
This is a new version of the GetPut Adventures game (and game engine) setup to run on AWS. The new the Spring Boot backed is on AWS Elastic Beanstalk and talks to a MySQL database on AWS RDS and an Angular frontend running on AWS Amplify.

The gameplay for this version is significantly different due to self-imposed limitations to keep things simple.

This game engine has two main components: Rooms and Actions.

Rooms are the descriptive text displayed on the screen and Actions are buttons that... do things.

Note: not all of this exists yet, this is what I've hashed out as being needed so far. (Yay for pansting NaNoWriMo!)

An action can do one or more of the following:
- Move a player between rooms
- Add or remove actions from player inventory
- Add or remove actions from a room
- Change game world settings

Actions can be valid:
- All the time
- When in a specific room
- When combined with specific room actions
- When combined with specific inventory actions

## Room-Action Example

Room A has a locked door that can be unlocked with Small Key.

Clicking on inventory action 'Small Key' will take the player to room 'Small Key' which is a description of the object and available actions.

Action 'Put Key in Pocket' will return the player to the room they were in when they looked at the key.

Action 'Drop Key' will remove the item from inventory and return the player to the room they were in when they looked at the key.

Action 'Unlock Door' will only show in Room A and will move the player to Room AA where the door is unlocked (I need to do this instead of swapping out the room action Locked Door to action Open Door for the room, because of the storyline I'm writing.)

## Backend Work
Right now the backend is responsible for fetching data from the database. There will probably be logic to apply the different world settings, but that may be something I do entirely with queries.
