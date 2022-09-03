package uk.co.tmdavies.shadowmod.events;

public class PlayerListener {

    /*

    EXAMPLE CODE

    Gets the world (level) and gets the block state of the given pos (location) then blocks the block object.
    - event.getLevel().getBlockState(event.getPos()).getBlock()

    Grabs the entity (player) that is triggering the event then grabs the item which is in its hand.
    - event.getEntity().getItemInHand(event.getHand()).getItem()

    Grabs the world (level) and sets the block at the given position to a slime block and sends an update to the world.
    - event.getLevel().setBlockAndUpdate(event.getPos(), Blocks.SLIME_BLOCK.defaultBlockState())

     */
//    @SubscribeEvent
//    public void onPlayerInteract(PlayerInteractEvent event) {
//
//        if (event.getLevel().getBlockState(event.getPos()).getBlock() != Blocks.HAY_BLOCK) return;
//        if (!event.getEntity().getItemInHand(event.getHand()).getItem().equals(ModItems.SHADOW_TEST.get())) return;
//
//        event.getLevel().setBlockAndUpdate(event.getPos(), Blocks.SLIME_BLOCK.defaultBlockState());
//
//        ResourceLocation resourceLocation = new ResourceLocation("minecraft", "block.grass.break");
//        SoundEvent soundEvent = new SoundEvent(resourceLocation);
//        BlockPos pos = event.getEntity().getOnPos();
//
//        event.getLevel().playSound(event.getEntity(), pos, soundEvent, SoundSource.PLAYERS, 1, 1);
//
//    }

}
