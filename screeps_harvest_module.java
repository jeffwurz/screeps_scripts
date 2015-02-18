/*
 * Module code goes here. Use 'module.exports' to export things:
 * module.exports = 'a thing';
 *
 * You can import it from another modules like this:
 * var mod = require('harvester'); // -> 'a thing'
 */
 module.exports = function (creep) {

	if(creep.energy < creep.energyCapacity) {
	    var source = creep.pos.findNearest(Game.SOURCES, {
    		filter: function(object) {
        		return object.energy > 0;
    		}
		});
		if(!creep.memory.mineSource){
		    creep.memory.mineSource = source.id;
		    console.log(creep.name + " will mine source: " + source.id)
		}
		//Add checks to compare if any enemies are in the regions surrounding
        if(source) {
          creep.moveTo(source);
          creep.harvest(source);
        }
	}
	else {
	    var spawn = creep.pos.findNearest(Game.MY_SPAWNS)
		creep.moveTo(spawn)
		creep.transferEnergy(spawn);
	}
}