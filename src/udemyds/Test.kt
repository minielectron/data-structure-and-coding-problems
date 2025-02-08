package udemyds

import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame
import kotlin.system.exitProcess

fun main() {
    // Create a JFrame to capture key events
    val frame = JFrame("ADB Key Event Listener")
    frame.setSize(300, 200)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

    // Add KeyListener
    frame.addKeyListener(object : KeyListener {
        override fun keyPressed(e: KeyEvent) {
            val keyCode = e.keyCode

            when {
                // Handle number keys (0-9)
                keyCode in KeyEvent.VK_0..KeyEvent.VK_9 -> {
                    sendAdbKeyEvent(7 + (keyCode - KeyEvent.VK_0)) // Map 0-9 to ADB keyevents 7-16
                }
                keyCode == KeyEvent.VK_H -> sendAdbKeyEvent(3) // Home key
                keyCode == KeyEvent.VK_I -> sendAdbKeyEvent(165) // Info
                keyCode == KeyEvent.VK_A -> sendAdbKeyEvent(158) // Apps
                keyCode == KeyEvent.VK_E -> sendAdbKeyEvent(172) // EPG
                keyCode == KeyEvent.VK_R -> sendAdbKeyEvent(130) // Recording
                keyCode == KeyEvent.VK_F -> sendAdbKeyEvent(90) // Forward
                keyCode == KeyEvent.VK_B -> sendAdbKeyEvent(89) // Backward
                keyCode == KeyEvent.VK_G -> sendAdbKeyEvent(222) // Google Assistant
                keyCode == KeyEvent.VK_U -> sendAdbKeyEvent(166) // Channel Up
                keyCode == KeyEvent.VK_D -> sendAdbKeyEvent(167) // Channel Down
                keyCode == KeyEvent.VK_PERIOD -> sendAdbKeyEvent(26) // Power
                e.keyChar in "0123456789" -> println("Unsupported key: ${e.keyChar}")

                // Handle special keys
                keyCode == KeyEvent.VK_UP -> sendAdbKeyEvent(19) // DPAD_UP
                keyCode == KeyEvent.VK_DOWN -> sendAdbKeyEvent(20) // DPAD_DOWN
                keyCode == KeyEvent.VK_LEFT -> sendAdbKeyEvent(21) // DPAD_LEFT
                keyCode == KeyEvent.VK_RIGHT -> sendAdbKeyEvent(22) // DPAD_RIGHT
                keyCode == KeyEvent.VK_ENTER -> sendAdbKeyEvent(66) // ENTER
                keyCode == KeyEvent.VK_BACK_SPACE -> sendAdbKeyEvent(4) // BACK
//                keyCode == KeyEvent. -> sendAdbKeyEvent(24) // Volume Up
//                keyCode == KeyEvent.VK_VOLUME_DOWN -> sendAdbKeyEvent(25) // Volume Down
                keyCode == KeyEvent.VK_ESCAPE -> {
                    println("Exiting...")
                    exitProcess(0) // Exit the program
                }
                else -> println("Unsupported special key: $keyCode")
            }
        }

        override fun keyReleased(e: KeyEvent) {
            // Do nothing on key release
        }

        override fun keyTyped(e: KeyEvent) {
            // Do nothing on key type
        }
    })

    frame.isVisible = true // Show the frame
}

// Function to send ADB key event
fun sendAdbKeyEvent(keyCode: Int) {
    val command = "adb shell input keyevent $keyCode"
    try {
        val process = Runtime.getRuntime().exec(command)
        process.waitFor()
        println("Sent ADB command: $command")
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
