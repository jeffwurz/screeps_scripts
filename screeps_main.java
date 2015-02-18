Game.spawns.Spawn1.createCreep(
	[Game.WORK, Game.CARRY, Game.MOVE],
	'Worker1'
);
Game.spawns.Spawn1.createCreep(
	[Game.WORK, Game.CARRY, Game.MOVE],
	'Worker2'
);
Game.spawns.Spawn1.createCreep(
	[Game.WORK, Game.CARRY, Game.MOVE],
	'Worker3'
);
Game.spawns.Spawn1.createCreep(
	[Game.TOUGH, Game.ATTACK, Game.MOVE, Game.MOVE],
	'Guard1'
);
Game.spawns.Spawn1.createCreep(
	[Game.TOUGH, Game.ATTACK, Game.MOVE, Game.MOVE],
	'Guard2'
);
Game.spawns.Spawn1.createCreep(
	[Game.WORK, Game.WORK, Game.WORK, Game.CARRY, Game.MOVE],
	'Builder1'
);

var n = 0;

var harvester = require('harvester');

for(var name1 in Game.creeps) {
	var creep = Game.creeps[name1];

	if(creep.memory.role == 'harvester') {
		harvester(creep);
	}
	
	if(creep.memory.role == 'guard') {
	    var targets = creep.room.find(Game.HOSTILE_CREEPS);
    	if(targets.length) {
    	    for(var name2 in targets) {
		        creep.moveTo(targets[name2]);
		        creep.attack(targets[name2]);
    	    }
	    }
    }
    
    if(creep.memory.role == 'attacker') {
	    var targets = creep.room.find(Game.HOSTILE_CREEPS);
    	if(targets.length) {
		    creep.moveTo(targets[0]);
		    creep.attack(targets[0]);
	    }
	    else
	   {
	       var target = creep.pos.findClosest(Game.MY_CREEPS);
            if(target) {
                creep.moveTo(target);
                creep.heal(target);
            }
	   }
    }

	if(creep.memory.role == 'builder') {
	
		if(creep.energy === 0) {
			creep.moveTo(Game.spawns.Spawn1);
			Game.spawns.Spawn1.transferEnergy(creep);
		}
		else {
			var targets = creep.room.find(Game.CONSTRUCTION_SITES);
			if(targets.length) {
				creep.moveTo(targets[0]);
				creep.build(targets[0]);
			}
		}
	}
}