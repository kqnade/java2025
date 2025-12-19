# テーマ20: Timerクラスとアニメーション

## ファイル一覧

### プログラムファイル
- **Task1.java** - Timerクラスの動作確認プログラム
- **Task2.java** - 単一画像の表示
- **Task3.java** - 複数画像の同時表示
- **Task4.java** - アニメーション実装

### 画像ファイル
- **chara.png** - 課題2用の単一画像
- **chara0.png** - 左向きの表情
- **chara1.png** - 正面の表情
- **chara2.png** - 右向きの表情
- **background.png** - 背景画像

### その他
- **report20.txt** - レポートファイル
- **CreateImages.java** - 画像生成用プログラム（提出不要）

## コンパイルと実行

```bash
# コンパイル
javac Task1.java
javac Task2.java
javac Task3.java
javac Task4.java

# 実行
java Task1  # 1秒ごとにpaintComponentが呼ばれることを確認
java Task2  # 単一画像表示
java Task3  # 複数画像表示
java Task4  # アニメーション（キャラクターが左右に移動）
```

## 課題の要点

### 課題1: Timerクラスの基本
- `javax.swing.Timer`を使用
- 1000ミリ秒(1秒)間隔でイベント発生
- `actionPerformed`から`repaint()`を呼び出し

### 課題2: 画像の読み込みと表示
- `Toolkit.getDefaultToolkit()`で画像読み込み
- `MediaTracker`で読み込み完了を待機
- `drawImage()`で固定位置に描画

### 課題3: 複数画像の表示
- 画像配列の使用
- for文で複数画像を一度に読み込み
- 異なる位置に配置して表示

### 課題4: アニメーション
- Timerで定期的に画面更新
- 座標変数（chara_x, chara_y）で位置制御
- 画像番号（chara_i）で表情切り替え
- 背景画像との重ね合わせ表示

## アニメーションの動作

Task4では以下のアニメーションを実装：
- キャラクターが左右に往復移動
- 移動速度: 3ピクセル/フレーム
- 更新間隔: 100ミリ秒
- 表情が3パターンで循環変化
- 端に到達すると方向転換
