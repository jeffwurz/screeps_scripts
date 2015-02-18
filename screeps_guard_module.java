/*
 * Module code goes here. Use 'module.exports' to export things:
 * module.exports = 'a thing';
 *
 * You can import it from another modules like this:
 * var mod = require('guard'); // -> 'a thing'
 */
module.exports = function (creep) {

var targets = creep.room.find(Game.HOSTILE_CREEPS);
    	if(targets.length) {
    	    for(var name2 in targets) {
		        creep.moveTo(targets[name2]);
		        creep.attack(targets[name2]);
    	    }
	    }
	    else
	    {
	    	creep.moveTo(Game.spawns[0]);
	    }
}