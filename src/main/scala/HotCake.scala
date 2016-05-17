/** Service interfaces */
trait OnOffDeviceComponent {
  val onOff: OnOffDevice

  trait OnOffDevice {
    def on(): Unit
    def off(): Unit
  }
}

trait SensorDeviceComponent {
  val sensor: SensorDevice

  trait SensorDevice {
    def isCoffeePresent: Boolean
  }
}

/** Service implementations */
trait OnOffDeviceComponentImpl extends OnOffDeviceComponent {
  class Heater extends OnOffDevice {
    def on(): Unit = println("heater.on")
    def off(): Unit = println("heater.off")
  }
}

trait SensorDeviceComponentImpl extends SensorDeviceComponent {
  class PotSensor extends SensorDevice {
    def isCoffeePresent = true
  }
}

/** Service declaring two dependencies that it wants injected */
trait WarmerComponentImpl { this: SensorDeviceComponent with OnOffDeviceComponent =>
  class Warmer {
    def trigger(): Unit = {
      if (sensor.isCoffeePresent) onOff.on()
      else onOff.off()
    }
  }
}

/** Instantiate the services in a module */
object ComponentRegistry extends
  OnOffDeviceComponentImpl with
  SensorDeviceComponentImpl with
  WarmerComponentImpl
{
  val onOff  = new Heater
  val sensor = new PotSensor
  val warmer = new Warmer
}

object Main extends App {
  val warmer = ComponentRegistry.warmer
  warmer.trigger()
}
